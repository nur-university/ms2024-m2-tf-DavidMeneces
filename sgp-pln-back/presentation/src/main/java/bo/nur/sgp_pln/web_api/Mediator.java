package bo.nur.sgp_pln.web_api;

import bo.nur.sgp_pln.application.mediator.IMediator;
import bo.nur.sgp_pln.application.mediator.IRequest;
import bo.nur.sgp_pln.application.mediator.IRequestHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class Mediator implements IMediator {


    @Inject
    private Instance<IRequestHandler<?, ?>> handlers;

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IRequest, R> CompletableFuture<R> handle(T request) {
        try {
            IRequestHandler<T, R> handler = (IRequestHandler<T, R>) findHandler(request);
            if (handler == null) {
                throw new RuntimeException("No handler found for request: " + request.getClass().getName());
            }
            return handler.handle(request);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }

    @SuppressWarnings("rawtypes")
    private IRequestHandler findHandler(IRequest request) {
        Class<?> requestClass = request.getClass();
        for (IRequestHandler handler : handlers) {
            Class<?> handlerClass = handler.getClass();
            if (canHandle(handlerClass, requestClass)) {
                return handler;
            }
        }
        return null;
    }

    private boolean canHandle(Class<?> handlerClass, Class<?> requestClass) {
        // Buscar en las interfaces implementadas
        Type[] genericInterfaces = handlerClass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericInterface;
                if (paramType.getRawType().equals(IRequestHandler.class)) {
                    Type[] typeArguments = paramType.getActualTypeArguments();
                    if (typeArguments.length >= 1) {
                        Type requestType = typeArguments[0];
                        if (requestType instanceof Class) {
                            if (((Class<?>) requestType).isAssignableFrom(requestClass)) {
                                return true;
                            }
                        } else if (requestType instanceof ParameterizedType) {
                            Type rawType = ((ParameterizedType) requestType).getRawType();
                            if (rawType instanceof Class && ((Class<?>) rawType).isAssignableFrom(requestClass)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        // Buscar en la superclase
        Class<?> superClass = handlerClass.getSuperclass();
        if (superClass != null && !superClass.equals(Object.class)) {
            return canHandle(superClass, requestClass);
        }

        return false;
    }
}

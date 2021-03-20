package es.codeurjc.mastercloudapps.planner.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.25.0)",
    comments = "Source: WeatherService.proto")
public final class WeatherServiceGrpc {

  private WeatherServiceGrpc() {}

  public static final String SERVICE_NAME = "es.codeurjc.mastercloudapps.planner.grpc.WeatherService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest,
      es.codeurjc.mastercloudapps.planner.grpc.Weather> getGetWeatherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeather",
      requestType = es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest.class,
      responseType = es.codeurjc.mastercloudapps.planner.grpc.Weather.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest,
      es.codeurjc.mastercloudapps.planner.grpc.Weather> getGetWeatherMethod() {
    io.grpc.MethodDescriptor<es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest, es.codeurjc.mastercloudapps.planner.grpc.Weather> getGetWeatherMethod;
    if ((getGetWeatherMethod = WeatherServiceGrpc.getGetWeatherMethod) == null) {
      synchronized (WeatherServiceGrpc.class) {
        if ((getGetWeatherMethod = WeatherServiceGrpc.getGetWeatherMethod) == null) {
          WeatherServiceGrpc.getGetWeatherMethod = getGetWeatherMethod =
              io.grpc.MethodDescriptor.<es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest, es.codeurjc.mastercloudapps.planner.grpc.Weather>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeather"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  es.codeurjc.mastercloudapps.planner.grpc.Weather.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("GetWeather"))
              .build();
        }
      }
    }
    return getGetWeatherMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherServiceStub newStub(io.grpc.Channel channel) {
    return new WeatherServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WeatherServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WeatherServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class WeatherServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getWeather(es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest request,
        io.grpc.stub.StreamObserver<es.codeurjc.mastercloudapps.planner.grpc.Weather> responseObserver) {
      asyncUnimplementedUnaryCall(getGetWeatherMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetWeatherMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest,
                es.codeurjc.mastercloudapps.planner.grpc.Weather>(
                  this, METHODID_GET_WEATHER)))
          .build();
    }
  }

  /**
   */
  public static final class WeatherServiceStub extends io.grpc.stub.AbstractStub<WeatherServiceStub> {
    private WeatherServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherServiceStub(channel, callOptions);
    }

    /**
     */
    public void getWeather(es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest request,
        io.grpc.stub.StreamObserver<es.codeurjc.mastercloudapps.planner.grpc.Weather> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWeatherMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WeatherServiceBlockingStub extends io.grpc.stub.AbstractStub<WeatherServiceBlockingStub> {
    private WeatherServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public es.codeurjc.mastercloudapps.planner.grpc.Weather getWeather(es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWeatherMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WeatherServiceFutureStub extends io.grpc.stub.AbstractStub<WeatherServiceFutureStub> {
    private WeatherServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeatherServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeatherServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<es.codeurjc.mastercloudapps.planner.grpc.Weather> getWeather(
        es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWeatherMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WEATHER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WeatherServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WeatherServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_WEATHER:
          serviceImpl.getWeather((es.codeurjc.mastercloudapps.planner.grpc.GetWeatherRequest) request,
              (io.grpc.stub.StreamObserver<es.codeurjc.mastercloudapps.planner.grpc.Weather>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WeatherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return es.codeurjc.mastercloudapps.planner.grpc.WeatherServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WeatherService");
    }
  }

  private static final class WeatherServiceFileDescriptorSupplier
      extends WeatherServiceBaseDescriptorSupplier {
    WeatherServiceFileDescriptorSupplier() {}
  }

  private static final class WeatherServiceMethodDescriptorSupplier
      extends WeatherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WeatherServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WeatherServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherServiceFileDescriptorSupplier())
              .addMethod(getGetWeatherMethod())
              .build();
        }
      }
    }
    return result;
  }
}

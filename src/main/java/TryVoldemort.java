///**
// * Created by petricek on 4/24/14.
// */
//import voldemort.server.VoldemortConfig;
//import voldemort.server.VoldemortConfig;
//
//
//public class TryVoldemort {
//
//    public void main(String[] args)
//    {
//
//        VoldemortConfig config = VoldemortConfig.loadFromEnvironmentVariable();
//        VoldemortServer server = new VoldemortServer(config);
//        server.start();
//
//        String bootstrapUrl = "tcp://localhost:6666";
//        StoreClientFactory factory = new SocketStoreClientFactory(new ClientConfig().setBootstrapUrls(bootstrapUrl));
//
//        // create a client that executes operations on a single store
//        StoreClient client = factory.getStoreClient("my_store_name");
//
//        // do some random pointless operations
//        Versioned value = client.get("some_key");
//        value.setObject("some_value");
//        client.put("some_key", value);
//
//    }
//}

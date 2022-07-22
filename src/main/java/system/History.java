package system;

import system.instances.Product;
import system.instances.User;

import java.util.LinkedList;
import java.util.List;

public class History {
    List<Recording> recordings;

    public History(){
        recordings = new LinkedList<>();
    }

    public void addRecording(User user, Product product){
        recordings.add(new Recording(user, product));
    }

    public List<User> getUsersByProduct(int productId){
        List<User> result = new LinkedList<>();

        for (Recording recording: recordings){

            if(recording.getProduct().getId() == productId){
                result.add(recording.getUser());
            }
        }
      return result;
    }

    public List<Product> getProductsByUser(int userId){
        List<Product> result = new LinkedList<>();

        for (Recording recording: recordings){

            if(recording.getUser().getId() == userId){
                result.add(recording.getProduct());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Recording recording: recordings){
            builder.append(recording);
        }
        return builder.toString();
    }
}

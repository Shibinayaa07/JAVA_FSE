package deepskilling.week_1.design_patterns;

import java.util.HashMap;
import java.util.Map;

public class Exercise11DependencyInjection {
    interface CustomerRepository {
        String findCustomerById(int customerId);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        private final Map<Integer, String> customers = new HashMap<>();

        CustomerRepositoryImpl() {
            customers.put(1, "Arjun");
            customers.put(2, "Priya");
        }

        public String findCustomerById(int customerId) {
            return customers.getOrDefault(customerId, "Customer not found");
        }
    }

    static class CustomerService {
        private final CustomerRepository repository;

        CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        String getCustomer(int customerId) {
            return repository.findCustomerById(customerId);
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        System.out.println(service.getCustomer(1));
        System.out.println(service.getCustomer(99));
    }
}

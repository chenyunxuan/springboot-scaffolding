import com.mlds.core.aspect.BaseControllerAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mlds")
public class UserApplication extends BaseControllerAspect{

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}

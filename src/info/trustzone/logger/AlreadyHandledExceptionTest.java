package info.trustzone.logger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlreadyHandledExceptionTest {

	@Test
	void test() {
		AlreadyHandledException e = new AlreadyHandledException();
		assertNotNull(e);
		//System.out.println(e.hashCode());
	}

}

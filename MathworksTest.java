import org.junit.Assert;
import org.junit.Test;

public class MathworksTest {
	@Test
	public void isTwinTest() {
		Assert.assertFalse(MathworksCoding.isTwin("adada", "abacd"));
	}
}

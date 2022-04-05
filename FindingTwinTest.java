import org.junit.Assert;
import org.junit.Test;

public class FindingTwinTest {
	@Test
	public void isTwinTest() {
		Assert.assertFalse(FindingTwin.isTwin("adada", "abacd"));
	}
}

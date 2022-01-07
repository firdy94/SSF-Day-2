
package ibf.ssf.day2workshop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Component;

@Component
public class NumberGenerator implements Serializable {

	private int numInput;
	private List<Integer> nums = new ArrayList<>();

	public NumberGenerator() {
	}

	public NumberGenerator(int numInput) {
		this.numInput = numInput;
	}

	public int getNumInput() {
		return this.numInput;
	}

	public void setNumInput(int numInput) {
		this.numInput = numInput;
	}

	public List<Integer> getNums() {
		return this.nums;
	}

	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}

	public List<Integer> resultNumbers(int numin) {
		nums = new ArrayList<>();

		while (nums.size() < numin) {
			int num = (new Random().nextInt(30)) + 1;
			if (nums.contains(num)) {
				num = (new Random().nextInt(30)) + 1;
			} else {
				nums.add(num);
			}
		}
		return nums;

	}

}

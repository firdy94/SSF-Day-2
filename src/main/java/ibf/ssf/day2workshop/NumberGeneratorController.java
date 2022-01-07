package ibf.ssf.day2workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NumberGeneratorController {

	@Autowired
	NumberGenerator numGen;

	@GetMapping("/generate")
	public String home(Model model) {
		model.addAttribute("numgen", numGen);
		return "generate";
	}

	// public ModelAndView landingpage() {
	// // ModelAndView modelAndView = new ModelAndView();
	// // modelAndView.setViewName("index.html");
	// // return modelAndView;
	// }

	@PostMapping("/generate")
	public String resultNumbers(@ModelAttribute NumberGenerator numGen, Model model) {
		numGen.setNums(numGen.resultNumbers(numGen.getNumInput()));
		List<Integer> selectedNum = numGen.getNums();
		System.out.println(selectedNum);
		List<String> selectedImgPaths = new ArrayList<>();
		for (int i = 0; i < selectedNum.size(); i++) {
			selectedImgPaths.add(String.format("number%d.jpg", selectedNum.get(i)));

		}
		System.out.println(selectedImgPaths);
		model.addAttribute("numbers", selectedImgPaths.toArray());

		return "result";
	}

}

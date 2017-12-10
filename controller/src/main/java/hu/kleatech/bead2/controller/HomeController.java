//@author Bozzay, Ádám
package hu.kleatech.bead2.controller;

import hu.kleatech.bead2.controller.ObjectTransferHandler.PencilTransfer;
import hu.kleatech.bead2.model.*;
import hu.kleatech.bead2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired private UserService userService;
	@Autowired private PencilService pencilService;
	@Autowired private PencilCaseService pencilCaseService;
	@Autowired private ObjectTransferHandler toc;

	@GetMapping(value={"/", "index"})
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		User actualUser = userService.getUser("bela123");
		model.addObject("allColor", Color.values());
		model.addObject("actualUser", actualUser);
		model.addObject("allPencilCase", pencilCaseService.getPencilCases(actualUser));
		return model;
	}

	@PostMapping("/pencilCase")
	public ResponseEntity<String> addPencilCase() {
		try {
			pencilCaseService.addPencilCase(userService.getUser("bela123"));
			return responseEntity("New pencil case added", HttpStatus.OK);
		}
		catch (Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/pencilCase")
	public ResponseEntity<String> deletePencilCase(@RequestParam("id") Long id) {
		try {
			pencilCaseService.removePencilCaseWithPencils(id);
			return responseEntity("Pencil case deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/pencil")
	public ResponseEntity<String> addPencil(@RequestBody PencilTransfer pencilTransfer) {
		try {
			Pencil pencil = toc.conv(pencilTransfer);
			pencilService.addPencil(pencil);
			return responseEntity("Pencil add successful", HttpStatus.OK);
		}
		catch(Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/pencil")
	public ResponseEntity<String> deletePencil(@RequestParam("id") Long id) {
		try {
			pencilService.removePencil(id);
			return responseEntity("Pencil deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/brake")
	public ResponseEntity<String> brakePencil(@RequestParam("id") Long id) {
		try {
			pencilService.breakPencil(id);
			return responseEntity("Pencil broken", HttpStatus.OK);
		}
		catch (Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/use")
	public ResponseEntity<String> usePencil(@RequestParam("id") Long id, @RequestParam("percentage") Integer percentage) {
		try {
			pencilService.usePencil(id, percentage);
			return responseEntity("Pencil used", HttpStatus.OK);
		}
		catch (Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/sharpen")
	public ResponseEntity<String> sharpenPencil(@RequestParam("id") Long id, @RequestParam("percentage") Integer percentage) {
		try {
			pencilService.sharpenPencil(id, percentage);
			return responseEntity("Pencil sharpened", HttpStatus.OK);
		}
		catch (Exception e) {
			return responseEntity("Unexpected error", HttpStatus.BAD_REQUEST);
		}
	}

	private ResponseEntity<String> responseEntity(String s, HttpStatus status) {
		return new ResponseEntity<>("[\"" + s + "\"]", status);
	}
}

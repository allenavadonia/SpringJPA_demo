package jpaTest.controller;

import jpaTest.entity.BonusEntity;
import jpaTest.entity.WorkerEntity;
import jpaTest.repository.BonusRepository;
import jpaTest.repository.WorkerRepository;
import jpaTest.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * The type Worker controller.
 */
@Controller
@Transactional
@RequestMapping(value = "/")
public class WorkerController {
    /**
     * The Worker repository.
     */
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    TitleRepository titleRepository;

    @Autowired
    BonusRepository bonusRepository;
    /**
     * Init binder.
     *
     * @param binder the binder
     */

    //Binding Date Time information to pattern so that it can update and add to new record
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    /**
     * Show a ll string.
     *
     * @param model the model
     * @return the stringS
     */

    //show home with list of worker
    @RequestMapping(method = GET)
    public String showALl(Model model) {
        List<WorkerEntity> list = workerRepository.findAll();
        model.addAttribute("workerList", list);
        return "home";
    }

    /**
     * Remove worker string.
     *
     * @param id the id
     * @return the string
     */

    //delete worker with id that receive in home page
    @RequestMapping(method = GET, value = "/delete/{id}")
    public String removeWorker(@PathVariable int id) {
        workerRepository.delete(id);
        return "redirect:/";
    }

    /**
     * New worker string.
     *
     * @param model the model
     * @return the string
     */

    //add show attribute for new record
    @RequestMapping(method = GET, value = "/new")
    public String newWorker(Model model) {
        model.addAttribute("worker", new WorkerEntity());
        model.addAttribute("method","post");
        model.addAttribute("msg", "Add new worker");
        model.addAttribute("action", "save");

        return "workerInfo";
    }

    /**
     * Save worker string.
     *
     * @param workerEntity the worker entity
     * @return the string
     */
    //after enter info of new worker
    //the "action" attribute in get method is value in post method
    @RequestMapping(method = POST, value = "/save", produces = "text/plain;charset=UTF-8")
    public String saveWorker(WorkerEntity workerEntity) {
        workerRepository.save(workerEntity);
        return "redirect:/";
    }

    @RequestMapping(method = GET, value = "/update/{id}")
    public String updateWorker(@PathVariable int id, Model model){
        model.addAttribute("worker", workerRepository.findOne(id));
        model.addAttribute("method","post");
        model.addAttribute("msg", "update worker");
        model.addAttribute("action", "updateWorker");

        model.addAttribute("type","update");
        return "workerInfo";
    }

    @RequestMapping(method = POST, value = "/update/updateWorker")
    public String finishUpdateWorker(@ModelAttribute  WorkerEntity worker){
        workerRepository.save(worker);
        return "redirect:/";
    }



}


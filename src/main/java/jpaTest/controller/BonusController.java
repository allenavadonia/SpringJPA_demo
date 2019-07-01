package jpaTest.controller;

import jpaTest.entity.BonusEntity;
import jpaTest.repository.BonusRepository;
import jpaTest.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * The type Bonus controller.
 */
@Controller
@RequestMapping(value = "/bonus")
public class BonusController {
    /**
     * The Bonus repository.
     */
    @Autowired
    BonusRepository bonusRepository;
    /**
     * The Worker repository.
     */
    @Autowired
    WorkerRepository workerRepository;

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
     * Show bonus string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @RequestMapping(value = "/{id}", method = GET)
    public String showBonus(Model model, @PathVariable int id) {
        List<BonusEntity> list = bonusRepository.findAllByWorkerRefId(workerRepository.findOne(id));
        model.addAttribute("bonusList", list);
        model.addAttribute("workerId", id);
        return "bonus";
    }

    /**
     * Add bonus string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/add", method = GET)
    public String addBonus(Model model) {
        model.addAttribute("msg", "add new bonus");
        model.addAttribute("bonus", new BonusEntity());
        model.addAttribute("method", "post");
        model.addAttribute("action", "saveBonus");
        return "addBonus";
    }

    /**
     * Save bonus string.
     *
     * @param bonusEntity the bonus entity
     * @return the string
     */
    @RequestMapping(method = POST, value = "/add/saveBonus", produces = "text/plain;charset=UTF-8")
    public String saveBonus(BonusEntity bonusEntity) {
        bonusRepository.save(bonusEntity);
        return "redirect:/";
    }

    /**
     * Del bonus string.
     *
     * @param id the id
     * @return the string
     */
    @RequestMapping(method = GET, value = "/delete/{id}")
    public String delBonus(@PathVariable int id) {
        bonusRepository.delete(id);
        return "redirect:/";
    }

    /**
     * Update string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @RequestMapping(method = GET, value = "/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("bonus", bonusRepository.findOne(id));
        model.addAttribute("method", "post");
        model.addAttribute("msg", "update bonus");
        model.addAttribute("action", "updateBonus");
        model.addAttribute("type", "update");
        return "addBonus";
    }

    /**
     * Finish update string.
     *
     * @param bonusEntity the bonus entity
     * @return the string
     */
    @RequestMapping(method = POST, value = "/update/updateBonus")
    public String finishUpdate(@ModelAttribute BonusEntity bonusEntity){
        bonusRepository.save(bonusEntity);
        return "redirect:/";
    }
}

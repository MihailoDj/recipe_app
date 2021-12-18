package com.mihailo.recipe_app.controllers;

import com.mihailo.recipe_app.commands.IngredientCommand;
import com.mihailo.recipe_app.commands.UnitOfMeasurementCommand;
import com.mihailo.recipe_app.services.IngredientService;
import com.mihailo.recipe_app.services.RecipeService;
import com.mihailo.recipe_app.services.UnitOfMeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasurementService unitOfMeasurementService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasurementService unitOfMeasurementService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasurementService = unitOfMeasurementService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.parseLong(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model){
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        model.addAttribute("uomList", unitOfMeasurementService.listAllUnitsOfMeasurement());
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command, HttpServletRequest request){
        //ToDo: check to see exactly why this didn't work as intended.

        Long uomId = Long.parseLong(request.getParameter("uom.id"));
        command.setUnitOfMeasurement(new UnitOfMeasurementCommand());
        command.getUnitOfMeasurement().setId(uomId);
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);


        log.debug("saved recipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}

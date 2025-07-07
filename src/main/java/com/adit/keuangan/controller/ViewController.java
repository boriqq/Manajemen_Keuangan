package com.adit.keuangan.controller;

import com.adit.keuangan.model.Transaction;
import com.adit.keuangan.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    private TransactionService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("transactions", service.getAllTransactions());
        model.addAttribute("balance", service.getBalance());
        return "index";
    }

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute Transaction t) {
        service.save(t);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTransaction(@PathVariable Long id, Model model) {
        Transaction t = service.getById(id);
        model.addAttribute("transaction", t);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateTransaction(@ModelAttribute Transaction t) {
        service.save(t);
        return "redirect:/";
    }
}

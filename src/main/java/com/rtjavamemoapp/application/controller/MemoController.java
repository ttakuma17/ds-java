package com.rtjavamemoapp.application.controller;

import com.rtjavamemoapp.application.resources.MemoForm;
import com.rtjavamemoapp.application.resources.MemoResponse;
import com.rtjavamemoapp.domain.model.Memo;
import com.rtjavamemoapp.domain.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;
    
    @GetMapping("/memos")
    public List<MemoResponse> getMemos() {
        return memoService.findAll().stream().map(MemoResponse::new).toList();
    }

    @GetMapping("/memos/{id}")
    public Memo findById(@PathVariable int id) {
        return memoService.findById(id);
    }

    @PostMapping("/memos")
    public void createMemo(@RequestBody MemoForm form) {
        memoService.createMemo(form);
    }

    @DeleteMapping("/memos/{id}")
    public void deleteMemo(@PathVariable int id) {
        memoService.deleteMemo(id);
    }

    @PatchMapping("/memos/{id}")
    public void updateMemo(@PathVariable int id, @RequestBody MemoForm form) {
        memoService.updateMemo(id, form);
    }
}


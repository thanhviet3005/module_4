package c0920g1.service.impl;

import c0920g1.model.CodeText;
import c0920g1.repository.CodeTextRepository;
import c0920g1.service.CodeTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class CodeTextImpl implements CodeTextService {
    @Autowired
    private CodeTextRepository codeTextRepository;

    @Override
    public List<CodeText> findAll() {
        return codeTextRepository.findAll();
    }

    @Override
    public CodeText findById(int id) {
        return null;
    }

    @Override
    public void save(CodeText codeText) {
        codeTextRepository.save(codeText);
    }

    @Override
    public void update(CodeText codeText) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public CodeText findBycodeLendReturn(String code) {
        return codeTextRepository.findByCodeLendReturn(code);
    }
}

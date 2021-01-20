package c0920g1.service;

import c0920g1.model.CodeText;

public interface CodeTextService extends Service<CodeText> {
    CodeText findBycodeLendReturn(String code);
}

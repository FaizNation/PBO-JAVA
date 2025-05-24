package com.example.belajar_spring.service;

import com.example.belajar_spring.model.Jurusan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JurusanService {
    private final List<Jurusan> jurusanList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Jurusan> getAllJurusan() {
        return jurusanList;
    }

    public Jurusan saveJurusan(Jurusan jurusan) {
        if (jurusan.getId() == null) {
            jurusan.setId(idCounter++);
            jurusanList.add(jurusan);
        }
        return jurusan;
    }


    public Jurusan getJurusanById(Long id) {
        return jurusanList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateJurusan(Jurusan jurusan) {
        jurusanList.replaceAll(m -> m.getId().equals(jurusan.getId()) ? jurusan : m);
    }
}
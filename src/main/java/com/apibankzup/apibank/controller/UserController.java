package com.apibankzup.apibank.controller;

import com.apibankzup.apibank.model.UsuarioModel;
import com.apibankzup.apibank.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getByIdUsuario(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<UsuarioModel>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> postUsuario(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<UsuarioModel> putUsuario(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable long id) {
        repository.deleteById(id);
    }
}

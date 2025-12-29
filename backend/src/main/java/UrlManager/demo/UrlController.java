package UrlManager.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UrlController {

    @Autowired
    private UrlService service;

    // POST → cria URL encurtada
    @PostMapping("/urls")
    public Url create(@RequestBody UrlRequest request) {
        return service.shortenUrl(request.getOriginalUrl());
    }

    // GET → lista URLs
    @GetMapping("/urls")
    public List<Url> listAll() {
        return service.listAll();
    }

    // DELETE → remove URL
    @DeleteMapping("/urls/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // GET → redireciona
    @GetMapping("/r/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
        Url url = service.findByShortUrl(shortUrl);

        if (url == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url.getOriginalUrl()))
                .build();
    }
}

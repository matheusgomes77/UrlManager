package UrlManager.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    // Cria URL encurtada
    public Url shortenUrl(String originalUrl) {
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(UUID.randomUUID().toString().substring(0, 8));
        return repository.save(url);
    }

    // Busca pelo shortUrl
    public Url findByShortUrl(String shortUrl) {
        return repository.findByShortUrl(shortUrl);
    }

    // Lista todas
    public List<Url> listAll() {
        return repository.findAll();
    }

    // Deleta por ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

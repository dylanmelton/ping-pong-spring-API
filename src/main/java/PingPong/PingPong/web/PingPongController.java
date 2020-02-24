package PingPong.PingPong.web;

import PingPong.PingPong.data.PingPongRepository;
import PingPong.PingPong.domain.PingPong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/ping_pong"})
public class PingPongController {
    private PingPongRepository pingPongRepository;

    @Autowired
    public PingPongController(PingPongRepository pingPongRepository) {
        this.pingPongRepository = pingPongRepository;
    }

    @PostMapping
    public PingPong submitMatches(@RequestBody PingPong pingPong) {
        return pingPongRepository.save(pingPong);
    }

    @GetMapping
    public Iterable<PingPong> allMatches() {
        return pingPongRepository.findAll();
    }

    @GetMapping("/{id}")
    public PingPong getById(@PathVariable Integer id) {
        return pingPongRepository.findById(id);
    }

    @PatchMapping("/{id}")
    public PingPong patchMatch(@PathVariable Integer id, @RequestBody PingPong pingPong) {
        PingPong original = pingPongRepository.findById(id);
        original.update(pingPong);
        return pingPongRepository.save(original);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        pingPongRepository.delete(id);
    }

}


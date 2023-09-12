package danekerscode.courseservice.controller;

import danekerscode.courseservice.dto.OutlineDTO;
import danekerscode.courseservice.service.OutlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("outline")
public class OutlineController {

    private final OutlineService outlineService;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(
            @PathVariable Long id
    ) {
        outlineService.delete(id);
    }


    @PatchMapping("{id}")
    void update(
            @PathVariable Long id,
            @RequestBody OutlineDTO outlineDTO
    ) {
        outlineService.update(id, outlineDTO);
    }
}

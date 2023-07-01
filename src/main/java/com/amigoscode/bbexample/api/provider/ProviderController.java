package com.amigoscode.bbexample.api.provider;

import com.amigoscode.bbexample.api.user.PageUserDto;
import com.amigoscode.bbexample.api.user.PageUserDtoMapper;
import com.amigoscode.bbexample.api.user.UserDto;
import com.amigoscode.bbexample.domain.provider.Provider;
import com.amigoscode.bbexample.domain.provider.ProviderService;
import com.amigoscode.bbexample.domain.user.User;
import com.amigoscode.bbexample.security.JWTUtil;
import com.amigoscode.bbexample.security.Security;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/providers",
        produces = "application/json",
        consumes = "application/json"
)
class ProviderController {

    private final ProviderService providerService;
    private final ProviderDtoMapper providerMapper;
    private final PageProviderDtoMapper pageProviderDtoMapper;

    @GetMapping( path = "/{id}")
    public ResponseEntity<ProviderDto> getProvider(@PathVariable Integer id) {
        Provider provider = providerService.findById(id);
        return ResponseEntity
                .ok(providerMapper.toDto(provider));
    }

    @GetMapping
    public ResponseEntity<PageProviderDto> getProviders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        PageProviderDto pageProviders = pageProviderDtoMapper.toPageDto(providerService.findAll(pageable));

        return ResponseEntity.ok(pageProviders);
    }

    @PostMapping
    public ResponseEntity<ProviderDto> saveProvider(@RequestBody ProviderDto dto) {

        Provider provider = providerService.save(providerMapper.toDomain(dto));
        return ResponseEntity
                .ok(providerMapper.toDto(provider));
    }

    @PutMapping
    public ResponseEntity<Void> updateProvider(@RequestBody ProviderDto dto) {
        providerService.update(providerMapper.toDomain(dto));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeProvider(@PathVariable Integer id){
        providerService.removeById(id);
        return ResponseEntity.noContent().build();
    }

}

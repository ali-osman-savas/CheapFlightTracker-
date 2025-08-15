package com.ucuzgider.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    
    @NotBlank(message = "Ad soyad gereklidir")
    @Size(max = 100, message = "Ad soyad en fazla 100 karakter olabilir")
    private String fullName;
    
    @NotBlank(message = "Email gereklidir")
    @Email(message = "Geçerli bir email adresi giriniz")
    @Size(max = 100, message = "Email en fazla 100 karakter olabilir")
    private String email;
    
    @NotBlank(message = "Şifre gereklidir")
    @Size(min = 6, max = 100, message = "Şifre en az 6, en fazla 100 karakter olmalıdır")
    private String password;
    
    @Size(max = 20, message = "Telefon en fazla 20 karakter olabilir")
    private String phone;
}
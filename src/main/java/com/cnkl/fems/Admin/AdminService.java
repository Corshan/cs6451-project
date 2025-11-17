package com.cnkl.fems.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }
}
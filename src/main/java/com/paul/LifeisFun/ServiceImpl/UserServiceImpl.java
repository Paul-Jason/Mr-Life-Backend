//package com.paul.LifeisFun.ServiceImpl;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.paul.LifeisFun.Dao.RoleRepository;
//import com.paul.LifeisFun.Dao.UserRepository;
//import com.paul.LifeisFun.Entity.Role;
//import com.paul.LifeisFun.Entity.User;
//import com.paul.LifeisFun.Service.UserService;
//
//@Service("userService")
//public class UserServiceImpl implements UserService{
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//    private RoleRepository roleRepository;
//	
////    @Autowired
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Override
//	public User findUserByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
//
//	@Override
//	public void saveUser(User user) {
//		user.setPassword(user.getPassword());
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//		userRepository.save(user);
//	}
//}

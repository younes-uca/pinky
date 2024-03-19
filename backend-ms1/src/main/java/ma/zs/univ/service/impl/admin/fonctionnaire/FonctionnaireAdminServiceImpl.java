package ma.zs.univ.service.impl.admin.fonctionnaire;


import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import ma.zs.univ.dao.criteria.core.fonctionnaire.FonctionnaireCriteria;
import ma.zs.univ.dao.facade.core.fonctionnaire.FonctionnaireDao;
import ma.zs.univ.dao.specification.core.fonctionnaire.FonctionnaireSpecification;
import ma.zs.univ.service.facade.admin.fonctionnaire.FonctionnaireAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import ma.zs.univ.zynerator.security.service.facade.UserService;
import ma.zs.univ.zynerator.security.service.facade.RoleService;
import ma.zs.univ.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class FonctionnaireAdminServiceImpl extends AbstractServiceImpl<Fonctionnaire, FonctionnaireCriteria, FonctionnaireDao> implements FonctionnaireAdminService {






    public Fonctionnaire findByReferenceEntity(Fonctionnaire t){
        return  dao.findByCin(t.getCin());
    }


    public List<Fonctionnaire> findAllOptimized() {
        return dao.findAllOptimized();
    }




    @Override
    public Fonctionnaire create(Fonctionnaire t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        /*if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }*/
        Fonctionnaire mySaved = super.create(t);

        return mySaved;
     }

    public Fonctionnaire findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Fonctionnaire.class, FonctionnaireSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    public FonctionnaireAdminServiceImpl(FonctionnaireDao dao) {
        super(dao);
    }

}

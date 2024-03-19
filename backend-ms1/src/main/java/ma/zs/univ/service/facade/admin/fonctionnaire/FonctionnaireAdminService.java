package ma.zs.univ.service.facade.admin.fonctionnaire;

import java.util.List;
import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import ma.zs.univ.dao.criteria.core.fonctionnaire.FonctionnaireCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface FonctionnaireAdminService extends  IService<Fonctionnaire,FonctionnaireCriteria>  {
    Fonctionnaire findByUsername(String username);
    boolean changePassword(String username, String newPassword);





}

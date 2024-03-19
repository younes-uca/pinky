package  ma.zs.univ.dao.specification.core.fonctionnaire;

import ma.zs.univ.dao.criteria.core.fonctionnaire.FonctionnaireCriteria;
import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class FonctionnaireSpecification extends  AbstractSpecification<FonctionnaireCriteria, Fonctionnaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("mail", criteria.getMail(),criteria.getMailLike());
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
    }

    public FonctionnaireSpecification(FonctionnaireCriteria criteria) {
        super(criteria);
    }

    public FonctionnaireSpecification(FonctionnaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

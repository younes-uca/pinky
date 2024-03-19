import {Component, OnInit} from '@angular/core';
import {FonctionnaireAdminService} from 'src/app/controller/service/admin/fonctionnaire/FonctionnaireAdmin.service';
import {FonctionnaireDto} from 'src/app/controller/model/fonctionnaire/Fonctionnaire.model';
import {FonctionnaireCriteria} from 'src/app/controller/criteria/fonctionnaire/FonctionnaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-fonctionnaire-list-admin',
  templateUrl: './fonctionnaire-list-admin.component.html'
})
export class FonctionnaireListAdminComponent extends AbstractListController<FonctionnaireDto, FonctionnaireCriteria, FonctionnaireAdminService>  implements OnInit {

    override fileName = 'Fonctionnaire';


     yesOrNoCredentialsNonExpired: any[] = [];
     yesOrNoEnabled: any[] = [];
     yesOrNoAccountNonExpired: any[] = [];
     yesOrNoAccountNonLocked: any[] = [];
     yesOrNoPasswordChanged: any[] = [];


    constructor( private fonctionnaireService: FonctionnaireAdminService  ) {
        super(fonctionnaireService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Fonctionnaire').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.yesOrNoCredentialsNonExpired =  [{label: 'CredentialsNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoEnabled =  [{label: 'Enabled', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoAccountNonExpired =  [{label: 'AccountNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoAccountNonLocked =  [{label: 'AccountNonLocked', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
                this.yesOrNoPasswordChanged =  [{label: 'PasswordChanged', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
            {field: 'username', header: 'Username'},
            {field: 'mail', header: 'Mail'},
            {field: 'credentialsNonExpired', header: 'Credentials non expired'},
            {field: 'enabled', header: 'Enabled'},
            {field: 'accountNonExpired', header: 'Account non expired'},
            {field: 'accountNonLocked', header: 'Account non locked'},
            {field: 'passwordChanged', header: 'Password changed'},
            {field: 'username', header: 'Username'},
            {field: 'password', header: 'Password'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Cin': e.cin ,
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
                 'Username': e.username ,
                 'Mail': e.mail ,
                'Credentials non expired': e.credentialsNonExpired? 'Vrai' : 'Faux' ,
                'Enabled': e.enabled? 'Vrai' : 'Faux' ,
                'Account non expired': e.accountNonExpired? 'Vrai' : 'Faux' ,
                'Account non locked': e.accountNonLocked? 'Vrai' : 'Faux' ,
                'Password changed': e.passwordChanged? 'Vrai' : 'Faux' ,
                 'Username': e.username ,
                 'Password': e.password ,
            }
        });

        this.criteriaData = [{
            'Cin': this.criteria.cin ? this.criteria.cin : environment.emptyForExport ,
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
            'Username': this.criteria.username ? this.criteria.username : environment.emptyForExport ,
            'Mail': this.criteria.mail ? this.criteria.mail : environment.emptyForExport ,
            'Credentials non expired': this.criteria.credentialsNonExpired ? (this.criteria.credentialsNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Enabled': this.criteria.enabled ? (this.criteria.enabled ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non expired': this.criteria.accountNonExpired ? (this.criteria.accountNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non locked': this.criteria.accountNonLocked ? (this.criteria.accountNonLocked ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Password changed': this.criteria.passwordChanged ? (this.criteria.passwordChanged ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Username': this.criteria.username ? this.criteria.username : environment.emptyForExport ,
            'Password': this.criteria.password ? this.criteria.password : environment.emptyForExport ,
        }];
      }
}

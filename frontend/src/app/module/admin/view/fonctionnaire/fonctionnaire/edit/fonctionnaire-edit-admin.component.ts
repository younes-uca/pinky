import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {FonctionnaireAdminService} from 'src/app/controller/service/admin/fonctionnaire/FonctionnaireAdmin.service';
import {FonctionnaireDto} from 'src/app/controller/model/fonctionnaire/Fonctionnaire.model';
import {FonctionnaireCriteria} from 'src/app/controller/criteria/fonctionnaire/FonctionnaireCriteria.model';



@Component({
  selector: 'app-fonctionnaire-edit-admin',
  templateUrl: './fonctionnaire-edit-admin.component.html'
})
export class FonctionnaireEditAdminComponent extends AbstractEditController<FonctionnaireDto, FonctionnaireCriteria, FonctionnaireAdminService>   implements OnInit {


    private _validFonctionnaireCin = true;
    private _validFonctionnaireNom = true;
    private _validFonctionnairePrenom = true;




    constructor( private fonctionnaireService: FonctionnaireAdminService ) {
        super(fonctionnaireService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validFonctionnaireCin = value;
        this.validFonctionnaireNom = value;
        this.validFonctionnairePrenom = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateFonctionnaireCin();
        this.validateFonctionnaireNom();
        this.validateFonctionnairePrenom();
    }
    public validateFonctionnaireCin(){
        if (this.stringUtilService.isEmpty(this.item.cin)) {
            this.errorMessages.push('Cin non valide');
            this.validFonctionnaireCin = false;
        } else {
            this.validFonctionnaireCin = true;
        }
    }
    public validateFonctionnaireNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validFonctionnaireNom = false;
        } else {
            this.validFonctionnaireNom = true;
        }
    }
    public validateFonctionnairePrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
            this.errorMessages.push('Prenom non valide');
            this.validFonctionnairePrenom = false;
        } else {
            this.validFonctionnairePrenom = true;
        }
    }






    get validFonctionnaireCin(): boolean {
        return this._validFonctionnaireCin;
    }
    set validFonctionnaireCin(value: boolean) {
        this._validFonctionnaireCin = value;
    }
    get validFonctionnaireNom(): boolean {
        return this._validFonctionnaireNom;
    }
    set validFonctionnaireNom(value: boolean) {
        this._validFonctionnaireNom = value;
    }
    get validFonctionnairePrenom(): boolean {
        return this._validFonctionnairePrenom;
    }
    set validFonctionnairePrenom(value: boolean) {
        this._validFonctionnairePrenom = value;
    }

}

package  ma.zs.univ.ws.facade.admin.fonctionnaire;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import ma.zs.univ.dao.criteria.core.fonctionnaire.FonctionnaireCriteria;
import ma.zs.univ.service.facade.admin.fonctionnaire.FonctionnaireAdminService;
import ma.zs.univ.ws.converter.fonctionnaire.FonctionnaireConverter;
import ma.zs.univ.ws.dto.fonctionnaire.FonctionnaireDto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import ma.zs.univ.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/fonctionnaire/")
public class FonctionnaireRestAdmin  extends AbstractController<Fonctionnaire, FonctionnaireDto, FonctionnaireCriteria, FonctionnaireAdminService, FonctionnaireConverter> {



    @Operation(summary = "upload one fonctionnaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple fonctionnaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all fonctionnaires")
    @GetMapping("")
    public ResponseEntity<List<FonctionnaireDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all fonctionnaires")
    @GetMapping("optimized")
    public ResponseEntity<List<FonctionnaireDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a fonctionnaire by prenom")
    @GetMapping("prenom/{prenom}")
    public ResponseEntity<FonctionnaireDto> findByPrenom(@PathVariable String prenom) {
        return super.findByReferenceEntity(new Fonctionnaire(prenom));
    }

    @Operation(summary = "Saves the specified  fonctionnaire")
    @PostMapping("")
    public ResponseEntity<FonctionnaireDto> save(@RequestBody FonctionnaireDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  fonctionnaire")
    @PutMapping("")
    public ResponseEntity<FonctionnaireDto> update(@RequestBody FonctionnaireDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of fonctionnaire")
    @PostMapping("multiple")
    public ResponseEntity<List<FonctionnaireDto>> delete(@RequestBody List<FonctionnaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified fonctionnaire")
    @DeleteMapping("")
    public ResponseEntity<FonctionnaireDto> delete(@RequestBody FonctionnaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified fonctionnaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple fonctionnaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a fonctionnaire and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FonctionnaireDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds fonctionnaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FonctionnaireDto>> findByCriteria(@RequestBody FonctionnaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated fonctionnaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FonctionnaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports fonctionnaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FonctionnaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets fonctionnaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FonctionnaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public FonctionnaireRestAdmin (FonctionnaireAdminService service, FonctionnaireConverter converter) {
        super(service, converter);
    }




}

package bsuir.labs.dao.database.entity;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "storage", schema = "labs")
public class SourceAndResultEntity {
    @EmbeddedId
    private InputDTO inputDTO;

    private Long total;
    private Long remains;

    public SourceAndResultEntity(InputDTO inputDTO) {
        this.inputDTO = inputDTO;
        this.total = (long) (inputDTO.getDivisible() / inputDTO.getDivisor());
        this.remains = (long) (inputDTO.getDivisible() % inputDTO.getDivisor());
    }

    public SourceAndResultEntity(InputDTO inputDTO, ResultDTO res) {
        this.inputDTO = inputDTO;
        this.total = res.getTotal();
        this.remains = res.getRemains();
    }

    public SourceAndResultEntity() {

    }

    public InputDTO getInputDTO() {
        return inputDTO;
    }

    public void setInputDTO(InputDTO inputDTO) {
        this.inputDTO = inputDTO;
    }

    public Long getTotal() {
        return total;
    }

    public Long getRemains() {
        return remains;
    }

    public ResultDTO getResultDTO() {
        return new ResultDTO(total, remains);
    }
}

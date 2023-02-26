package bsuir.labs.core.dtos;

import java.io.Serializable;
import java.util.Objects;

public class ResultDTO implements Serializable {
    private Long total;
    private Long remains;

    public ResultDTO(Long divisible, Long divider) {
        this.total = divisible;
        this.remains = divider;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getRemains() {
        return remains;
    }

    public void setRemains(Long remains) {
        this.remains = remains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDTO divideDTO = (ResultDTO) o;
        return Objects.equals(total, divideDTO.total) && Objects.equals(remains, divideDTO.remains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, remains);
    }


}

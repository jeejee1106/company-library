package com.company.library.dto;

import com.company.library.entity.Library;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class LibraryDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SaveLibraryReq {

        @NotNull(message = "name 값이 비어있음")
        @Schema(example = "test도서관", description = "도서관 이름")
        private String name;

        @NotNull(message = "delYn 값이 비어있음")
        @Schema(example = "N", description = "삭제여부")
        private String delYn;

        public Library toEntity() {
            return Library.builder()
                    .name(name)
                    .delYn(delYn)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public class UpdateLibraryReq {

        @NotNull(message = "no 값이 비어있음")
        @Schema(example = "뭐지", description = "도서관 고유 no")
        private Long libraryNo;

        @NotNull(message = "name 값이 비어있음")
        @Schema(example = "뭐지", description = "도서관명")
        private String name;

        @NotNull(message = "delYn 값이 비어있음")
        @Schema(example = "뭐지", description = "삭제여부")
        private String delYn;

        public Library toEntity() {
            return Library.builder()
                    .libraryNo(libraryNo)
                    .name(name)
                    .delYn(delYn)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class LibraryRes {
        private Long libraryNo;
        private String name;
        private LocalDateTime createDt;
        private LocalDateTime updateDt;
        private String delYn;

        public LibraryRes(Library entity) {
            this.libraryNo = entity.getLibraryNo();
            this.name = entity.getName();
            this.createDt = entity.getCreateDt();
            this.updateDt = entity.getUpdateDt();
            this.delYn = entity.getDelYn();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class SelectLibraryListRes {

        private List<Library> list;
        private int totalCount;

        public SelectLibraryListRes(List<Library> list, int totalCount) {
            this.list = list;
            this.totalCount = totalCount;
        }
    }

}
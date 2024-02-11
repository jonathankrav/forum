package telran.java51.forum.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class FindPostsByPeriodDto {
	
    LocalDateTime dateFrom; //"2020-08-25",
    LocalDateTime dateTo; // "2020-08-26"

}

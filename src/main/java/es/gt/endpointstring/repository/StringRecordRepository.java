package es.gt.endpointstring.repository;

import es.gt.endpointstring.model.StringRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringRecordRepository extends JpaRepository<StringRecord, Long> {
}

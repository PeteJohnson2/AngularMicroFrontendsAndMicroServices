/**
 *    Copyright 2019 Sven Loesekann
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package de.xxx.payment.domain.model.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelRepository {
	Hotel save(Hotel hotel);
	Optional<Hotel> findById(UUID id);
	Iterable<Hotel> findByPaid(boolean paid);
	Iterable<Hotel> findAllById(List<UUID> ids);
	void deleteById(UUID id);
}

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
package de.xxx.hotelselection.usecase.mapper

import de.xxx.hotelselection.domain.model.dto.BookingDto
import de.xxx.hotelselection.domain.model.entity.Booking
import de.xxx.hotelselection.domain.model.entity.Hotel
import org.springframework.stereotype.Component

@Component
class BookingMapper {
    fun toDtos(bookings: Set<Booking>): Set<BookingDto> {
        return bookings.map { this.toDto(it) }.toSet()
    }

    fun toDto(booking: Booking): BookingDto {
        return BookingDto(booking.id, booking.from, booking.to)
    }

    fun toEntities(bookingDtos: Set<BookingDto>, hotel: Hotel): Set<Booking> {
        return bookingDtos.map { this.toEntity(it, hotel) }.toSet()
    }

    fun toEntity(bookingDto: BookingDto, hotel: Hotel): Booking {
        return Booking(bookingDto.id, hotel, bookingDto.from, bookingDto.to)
    }
}
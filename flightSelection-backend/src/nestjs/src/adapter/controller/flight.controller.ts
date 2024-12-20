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
import { Controller, Get, Param } from '@nestjs/common';
import { FlightService } from '../../usecase/service/flight.service';
import { FlightMapper } from 'src/usecase/mapper/flight-mapper.service';
import { FlightDto } from 'src/domain/dto/flight-dto';

@Controller('rest/flights')
export class FlightController {
  constructor(private readonly flightService: FlightService, private readonly flightMapper: FlightMapper) {}

  @Get('/all')
  getAllFlights(): Promise<FlightDto[]> {
    return this.flightService.getAllFlights().then(entities => !!entities ? entities.map(entity => this.flightMapper.toDto(entity) as FlightDto) : []);
  }

  @Get('/id/:id')
  getFlightById(@Param('id') id: string): Promise<FlightDto | null> {
    return this.flightService.getFlightById(id).then(flight => !!flight ? this.flightMapper.toDto(flight) || null : null);
  }
}

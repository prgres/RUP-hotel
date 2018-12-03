import React from "react";
import "./HotelTable.css";

function HotelTable(props) {
	return (
		<table>
			<caption>Nasze propozycje dla Ciebie</caption>
			<thead>
				<tr>
					<th scope="col">Rodzaj pokoju</th>
					<th scope="col">Typ pokoju</th>
					<th scope="col">Cena</th>
					<th scope="col">Okres Pobytu</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td data-label="Rodzaj pokoju">Visa - 3412</td>
					<td data-label="Typ pokoju">04/01/2016</td>
					<td data-label="Cena">$1,190</td>
					<td data-label="Okres pobytu">03/01/2016 - 03/31/2016</td>
				</tr>
				<tr>
					<td scope="row" data-label="Rodzaj pokoju">
						Visa - 6076
					</td>
					<td data-label="Typ pokoju">03/01/2016</td>
					<td data-label="Cena">$2,443</td>
					<td data-label="Okres pobytu">02/01/2016 - 02/29/2016</td>
				</tr>
				<tr>
					<td scope="row" data-label="Rodzaj pokoju">
						Corporate AMEX
					</td>
					<td data-label="Typ pokoju">03/01/2016</td>
					<td data-label="Cena">$1,181</td>
					<td data-label="Okres pobytu">02/01/2016 - 02/29/2016</td>
				</tr>
				<tr>
					<td scope="row" data-label="Rodzaj pokoju">
						Visa - 3412
					</td>
					<td data-label="Typ pokoju">02/01/2016</td>
					<td data-label="Cena">$842</td>
					<td data-label="Okres pobytu">01/01/2016 - 01/31/2016</td>
				</tr>
			</tbody>
		</table>
	);
}

export default HotelTable;

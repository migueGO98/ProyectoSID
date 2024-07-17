import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { Registros } from 'src/app/generate/openapi';

import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoService {
  private httpCliente = inject(HttpClient);

  private apiUrl = signal(`${environment.apiBasePath}/api/empleados`);

  // Obtener el header para la petición HTTP
  private getHeaders(): HttpHeaders {
    const token =
      'eyJhbGciOiJSUzI1NiIsImtpZCI6Ilg1ZVhrNHh5b2pORnVtMWtsMll0djhkbE5QNC1jNTdkTzZRR1RWQndhTmsiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiI3YThkN2EyMy1lMmE4LTRkNmItOTAwYy1jMjYzOTE0NDE4MDIiLCJpc3MiOiJodHRwczovL2FncmljdWx0dXJhZGdlYy5iMmNsb2dpbi5jb20vNmFjODUyYzQtMGZlYy00YzA5LThmNmQtNzI4NTdmMGM4N2I4L3YyLjAvIiwiZXhwIjoxNzIxMjI4MDQwLCJuYmYiOjE3MjEyMjQ0NDAsImlkcCI6IkxvY2FsQWNjb3VudCIsInN1YiI6IjQwY2ExMDg0LTBmMjMtNGQwNy1iNDk2LWM2NjIyN2ExNWFiNSIsImV4dGVuc2lvbl9hY3Rpdm8iOnRydWUsImV4dGVuc2lvbl9mZWNoYUluZ3Jlc28iOiIyMDI0LTA2LTAxIiwiZXh0ZW5zaW9uX25vbWJyZUNvbXBsZXRvIjoiRmFiaWFuIENhcmxvcyBkZSBsYSBMw7NwZXogRXN0cmFkYSIsImV4dGVuc2lvbl9pZFRpcG9QbGF6YSI6IlNQQyIsImV4dGVuc2lvbl9pZFN1YmRpcmVjY2lvbiI6IlNVQkFETU9OT0MiLCJleHRlbnNpb25faWRSb2xlcyI6IkFETUlOIiwiZXh0ZW5zaW9uX2lkRGlyZWNjaW9uIjoiREdFQyIsImV4dGVuc2lvbl9pZEVtcGxlYWRvIjoiTE9FRjEwNjIwMjQiLCJleHRlbnNpb25faWRQdWVzdG8iOiJOQTEiLCJleHRlbnNpb25faWRSZWdpb24iOiJPQyIsInRmcCI6IkIyQ18xX1JPUEMiLCJhenAiOiI3YThkN2EyMy1lMmE4LTRkNmItOTAwYy1jMjYzOTE0NDE4MDIiLCJ2ZXIiOiIxLjAiLCJpYXQiOjE3MjEyMjQ0NDB9.g02oW5bXIlnJUowApDeAKS8NLDRkTFAHLHp6-QaWf8UySaAkK5zL7X_Do37qcbc6cOQia4bDPmaAFaeMp9qPQIkYb5NotaKC1-xXXBFHA_QfJpXP5rHnFI7IDmFIbnzeafmlaJWoI7MY9p0Y1A85-dqe-cmo3TO-uUYaU401NuC42yE9xqiIJy0R5spn4ATpKvAZLxJpIzFiXuoCIu28ykP984V25bFYhZWqsFE37fK83JM2SOxhhZSqU4-wG7M8JpBpNjVhEwxgknPjsUXww9es1bwuI1IJ20Se4_A8ZeINLOHjgMrqyNKVK0zljwfNryiAu3ubtjL6bnoYvLPa4A';
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }

  recuperarMotivosBaja(): Observable<Registros[]> {
    return this.httpCliente.get<Registros[]>(`${this.apiUrl()}/motivosBaja`, {
      headers: this.getHeaders(),
    });
  }
}

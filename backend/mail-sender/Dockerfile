FROM golang:1.21
WORKDIR /app
COPY . .
RUN go build -o mail-sender
EXPOSE 8082
CMD ["./mail-sender"]

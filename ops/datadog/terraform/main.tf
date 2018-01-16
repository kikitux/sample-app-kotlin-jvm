variable datadog_api_key {}
variable datadog_app_key {}

# Configure the Datadog provider
provider "datadog" {
  api_key = "${var.datadog_api_key}"
  app_key = "${var.datadog_app_key}"
}

# Create a new Datadog timeboard
resource "datadog_timeboard" "http" {
  title       = "HTTP Requests Timeboard (created via Terraform)"
  description = "created using the Datadog provider in Terraform"
  read_only   = true

  graph {
    title = "HTTP requests counts"
    viz   = "timeseries"

    request {
      q    = "sum:http.server.requests.count{*} by {uri}"
      type = "area"
    }
  }

#  template_variable {
#    name   = "host"
#    prefix = "host"
#  }

}

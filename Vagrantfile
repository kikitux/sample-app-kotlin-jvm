Vagrant.configure("2") do |config|
  config.vm.provider "virtualbox"
  config.vm.define vm_name = "xe" do |xe|
    xe.vm.box = "xe"
    xe.vm.box_url = "dep/github/kikitux/packer-oraclelinux-ovf/xe.box"
    xe.vm.network "forwarded_port", guest: 1521, host: 1521
    xe.vm.hostname = vm_name
    xe.vm.provision "shell", path: "provision/script.sh"
    xe.vm.provision 'datadog', type: :shell, path: "provision/datadog.sh"
  end
end

DESCRIPTION = "Components for UPnP."
HOMEPAGE = "http://github.com/mnlipp/CoCy"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS_${PN} = "python-circuits python-circuits-bricks"
RDEPENDS_${PN} = "python-circuits python-circuits-bricks"

SRC_URI = "git://github.com/mnlipp/CoCy.git file://setup.patch"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "0.1.5+git${SRCPV}"
PKGV = "0.1.5+git${GITPKGV}"
PR = "r6"

S = "${WORKDIR}/git"

inherit distutils

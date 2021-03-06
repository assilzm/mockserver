package org.mockserver.mappers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ContentTypeMapperTest {

    private List<String> utf8ContentTypes = Arrays.asList(
            "application/atom+xml",
            "application/ecmascript",
            "application/javascript",
            "application/json",
            "application/jsonml+json",
            "application/lost+xml",
            "application/wsdl+xml",
            "application/xaml+xml",
            "application/xhtml+xml",
            "application/xml",
            "application/xml-dtd",
            "application/xop+xml",
            "application/xslt+xml",
            "application/xspf+xml",
            "image/svg+xml",
            "text/css",
            "text/csv",
            "text/html",
            "text/plain",
            "text/richtext",
            "text/sgml",
            "text/tab-separated-values",
            "text/x-fortran",
            "text/x-java-source"
    );

    private List<String> binaryContentTypes = Arrays.asList(
            "application/applixware",
            "application/font-tdpfr",
            "application/java-archive",
            "application/java-serialized-object",
            "application/java-vm",
            "application/mp4",
            "application/octet-stream",
            "application/pdf",
            "application/pkcs10",
            "application/pkix-cert",
            "application/x-font-bdf",
            "application/x-font-ghostscript",
            "application/x-font-linux-psf",
            "application/x-font-otf",
            "application/x-font-pcf",
            "application/x-font-snf",
            "application/x-font-ttf",
            "application/x-font-type1",
            "application/font-woff",
            "application/x-java-jnlp-file",
            "application/x-latex",
            "application/x-shockwave-flash",
            "application/x-silverlight-app",
            "application/x-stuffit",
            "application/x-tar",
            "application/x-tex",
            "application/x-tex-tfm",
            "application/x-x509-ca-cert",
            "application/zip",
            "audio/midi",
            "audio/mp4",
            "audio/mpeg",
            "audio/ogg",
            "audio/x-aiff",
            "audio/x-wav",
            "audio/xm",
            "image/bmp",
            "image/gif",
            "image/jpeg",
            "image/png",
            "image/sgi",
            "image/tiff",
            "image/x-xbitmap",
            "video/jpeg",
            "video/mp4",
            "video/mpeg",
            "video/ogg",
            "video/quicktime",
            "video/x-msvideo",
            "video/x-sgi-movie"
    );

    @Test
    public void shouldNotDetectAsBinaryBody() {
        for (String contentType : utf8ContentTypes) {
            assertThat(contentType + " should not be binary", new ContentTypeMapper().isBinary(contentType), is(false));
        }
    }

    @Test
    public void shouldDetectAsBinaryBody() {
        for (String contentType : binaryContentTypes) {
            assertThat(contentType + " should be binary", ContentTypeMapper.isBinary(contentType), is(true));
        }
    }

    @Test
    public void shouldDefaultToNotBinary() {
        assertThat("null should not be binary", ContentTypeMapper.isBinary(null), is(false));
    }
}
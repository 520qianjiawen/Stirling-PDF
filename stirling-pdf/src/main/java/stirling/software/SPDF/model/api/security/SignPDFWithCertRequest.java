package stirling.software.SPDF.model.api.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;
import stirling.software.common.model.api.PDFFile;

@Data
@EqualsAndHashCode(callSuper = true)
public class SignPDFWithCertRequest extends PDFFile {

    @Schema(
            description = "The type of the digital certificate",
            allowableValues = {"PEM", "PKCS12", "JKS"},
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String certType;

    @Schema(
            description =
                    "The private key for the digital certificate (required for PEM type"
                            + " certificates)")
    private MultipartFile privateKeyFile;

    @Schema(description = "The digital certificate (required for PEM type certificates)")
    private MultipartFile certFile;

    @Schema(description = "The PKCS12 keystore file (required for PKCS12 type certificates)")
    private MultipartFile p12File;

    @Schema(description = "The JKS keystore file (Java Key Store)")
    private MultipartFile jksFile;

    @Schema(description = "The password for the keystore or the private key", format = "password")
    private String password;

    @Schema(
            description = "Whether to visually show the signature in the PDF file",
            defaultValue = "false",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean showSignature;

    @Schema(description = "The reason for signing the PDF", defaultValue = "Signed by SPDF")
    private String reason;

    @Schema(description = "The location where the PDF is signed", defaultValue = "SPDF")
    private String location;

    @Schema(description = "The name of the signer", defaultValue = "SPDF")
    private String name;

    @Schema(
            description =
                    "The page number where the signature should be visible. This is required if"
                            + " showSignature is set to true",
            defaultValue = "1")
    private Integer pageNumber;

    @Schema(
            description = "Whether to visually show a signature logo along with the signature",
            defaultValue = "true",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean showLogo;
}

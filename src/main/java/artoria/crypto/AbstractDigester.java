package artoria.crypto;

import artoria.util.Assert;
import artoria.util.CloseUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

import static artoria.common.Constants.DEFAULT_CHARSET_NAME;

/**
 * Abstract digester.
 * @see artoria.crypto.Digester
 * @author Kahle
 */
public abstract class AbstractDigester implements Digester {
    private String charset = DEFAULT_CHARSET_NAME;
    private String algorithm;

    @Override
    public String getAlgorithm() {

        return algorithm;
    }

    @Override
    public void setAlgorithm(String algorithm) {
        Assert.notBlank(algorithm, "Parameter \"algorithm\" must not blank. ");
        this.algorithm = algorithm;
    }

    public String getCharset() {

        return charset;
    }

    public void setCharset(String charset) {
        Assert.notBlank(charset, "Parameter \"charset\" must not blank. ");
        this.charset = charset;
    }

    public byte[] digest(String data) throws GeneralSecurityException {
        Assert.notBlank(data, "Parameter \"data\" must not blank. ");
        Charset charset = Charset.forName(getCharset());
        byte[] bytes = data.getBytes(charset);
        return digest(bytes);
    }

    public byte[] digest(File file) throws GeneralSecurityException, IOException {
        Assert.notNull(file, "Parameter \"file\" must not null. ");
        InputStream in = new FileInputStream(file);
        try {
            return digest(in);
        }
        finally {
            CloseUtils.closeQuietly(in);
        }
    }

}

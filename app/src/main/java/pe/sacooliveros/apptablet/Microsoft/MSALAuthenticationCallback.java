package pe.sacooliveros.apptablet.Microsoft;

import com.microsoft.identity.client.AuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;

public interface MSALAuthenticationCallback {

    void onMsalAuthSuccess(AuthenticationResult authenticationResult);
    void onMsalAuthError(MsalException exception);
    void onMsalAuthError(Exception exception);
    void onMsalAuthCancel();
}
